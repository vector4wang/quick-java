package feature_learn.annotation.db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCretor {
	public static void main(String[] args) {

		// 简单点只对Member做处理
		try {
			Class<?> cl = Class.forName("feature_learn.annotation.db.Member");
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if (dbTable == null) {
				System.out.println("No DBTable annotations in class " + cl.getName());
				System.exit(0);
			}

			String tableName = dbTable.name();
			if (tableName.length() < 1) {
				tableName = cl.getName().toUpperCase();
			}
			List<String> columnDefs = new ArrayList<>();
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				if (anns.length < 1) {
					continue;
				}
				if (anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					if (sInt.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT" + getContraints(sInt.constraints()));
				}
				if (anns[0] instanceof SQLString) {
					SQLString sString = (SQLString) anns[0];
					if (sString.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sString.name();
					}
					columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getContraints(
							sString.constraints()));
				}

			}

			StringBuilder sb = new StringBuilder("CREATE TABLE " + tableName + " (");
			for (String columnDef : columnDefs) {
				sb.append("\n	" + columnDef + ", ");
			}

			// , 与 空格 占两个长度
			String tableCreate = sb.subSequence(0, sb.length() - 2) + ");";

			System.out.println("Table create SQL is: \n" + tableCreate);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static String getContraints(Constraints constraints) {
		String result = "";
		if (!constraints.allowNull()) {
			result += " NOT NULL ";
		}
		if (constraints.primaryKey()) {
			result += " PRIMARY KEY ";
		}
		if (constraints.unique()) {
			result += " UNIQUE ";
		}
		return result;
	}
}
