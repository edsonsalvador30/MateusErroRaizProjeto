package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TaskAdminBusiness {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// TaskAdminBusiness
	public static Var confirm_assignment() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Task"),
						Var.valueOf(
								"update Task set assignmentDate = :assignmentDate, status = :status where id = :id"),
						Var.valueOf("assignmentDate", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("status", blockly.TasksBusiness.assigned()),
						Var.valueOf("id", cronapi.screen.Operations.getValueOfField(Var.valueOf("Task.active.id"))));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
