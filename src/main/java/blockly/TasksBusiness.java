package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TasksBusiness {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Tasks
	public static Var todo() throws Exception {
		return new Callable<Var>() {

			private Var me = Var.VAR_NULL;
			private Var listaStatus = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("ToDo");
			}
		}.call();
	}

	/**
	 */
	// Describe this function...
	public static void assignToMe() throws Exception {
		new Callable<Var>() {

			private Var me = Var.VAR_NULL;

			public Var call() throws Exception {
				me = blockly.UserSkillsBusiness.getLoginfromLoggedUser();
				System.out.println(Var.valueOf(Var.valueOf("I am ").toString() + me.toString()).getObjectAsString());
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Task"),
						Var.valueOf(
								"update Task set status = :status, cronappuser_email = :cronappuser_email where id = :id"),
						Var.valueOf("status", requested()), Var.valueOf("cronappuser_email", me),
						Var.valueOf("id", cronapi.screen.Operations.getValueOfField(Var.valueOf("Task.active.id"))));
				System.out.println(Var.valueOf("fim").getObjectAsString());
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Describe this function...
	public static Var assigned() throws Exception {
		return new Callable<Var>() {

			private Var me = Var.VAR_NULL;
			private Var listaStatus = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("Assigned");
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Describe this function...
	public static Var requested() throws Exception {
		return new Callable<Var>() {

			private Var me = Var.VAR_NULL;
			private Var listaStatus = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("Requested");
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Describe this function...
	public static Var status_list() throws Exception {
		return new Callable<Var>() {

			private Var listaStatus = Var.VAR_NULL;

			public Var call() throws Exception {
				listaStatus = cronapi.list.Operations.newList(
						cronapi.map.Operations.createObjectMapWith(Var.valueOf("status", Var.valueOf("Todo"))),
						cronapi.map.Operations.createObjectMapWith(Var.valueOf("status", Var.valueOf("Requested\n"))),
						cronapi.map.Operations.createObjectMapWith(Var.valueOf("status", Var.valueOf("Assigned"))),
						cronapi.map.Operations.createObjectMapWith(Var.valueOf("status", Var.valueOf("Done"))));
				System.out.println(listaStatus.getObjectAsString());
				return listaStatus;
			}
		}.call();
	}

}
