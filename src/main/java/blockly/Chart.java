package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.lang.Math;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Chart {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Chart
	public static Var chartCreate() throws Exception {
		return new Callable<Var>() {

			private Var months = Var.VAR_NULL;
			private Var skillsCategory = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf("abc").getObjectAsString());
				months = cronapi.database.Operations.query(Var.valueOf("app.entity.User"), Var.valueOf(
						"select m.name from User u, Month m where m.num = extract(month u.creation_date) group by m.name order by m.num asc"));
				skillsCategory = cronapi.database.Operations.query(Var.valueOf("app.entity.User"), Var.valueOf(
						"select m.name from User u, Month m where m.num = extract(month u.creation_date) group by m.name order by m.num asc"));
				cronapi.chart.Operations.createChart(Var.valueOf("chart3239"), Var.valueOf("doughnut"),
						cronapi.list.Operations.newList(Var.valueOf("BackEnd"), Var.valueOf("FrontEnd"),
								Var.valueOf("Mobile"), Var.valueOf("Consulting"), Var.valueOf("Tester"),
								Var.valueOf("DataBase"), Var.valueOf("UX")),
						Var.valueOf(
								"{\n    \"responsive\":true,\n    \"legend\": {\n      \"display\": true,\n      \"position\": \"left\",\n      \"labels\": {\n        \"fontColor\": \"#000080\"\n      }\n    },\n    \"animation\": {\n       \"animateScale\":true,\n       \"animateRotate\":true\n    },\n    \"title\":{\n      \"display\": true,\n      \"text\": \"Habilidades por Usuários\"\n    }\n}"),
						cronapi.chart.Operations.createChartSerie(Var.valueOf("Skills/User"),
								cronapi.list.Operations.newList(
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10)),
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10)),
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10)),
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10)),
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10)),
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10)),
										cronapi.math.Operations.randomInt(Var.valueOf(1), Var.valueOf(10))),
								Var.VAR_NULL));
				cronapi.chart.Operations.createChart(Var.valueOf("chart7952"), Var.valueOf("bar"), months,
						Var.valueOf(
								"{\n    \"responsive\":true,\n    \"animation\": {\n       \"animateScale\":true,\n       \"animateRotate\":true\n    },\n    \"title\":{\n      \"display\": true,\n      \"text\": \"Usuários por Mês\"\n    }\n}"),
						cronapi.chart.Operations.createChartSerie(Var.valueOf("User"),
								cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
										Var.valueOf(
												"select COUNT(u.id) from User u  where u.creation_date != null group by extract(month u.creation_date) order by extract(month u.creation_date) asc")),
								Var.VAR_NULL));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
