package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserUtils {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// UserUtils
	public static Var getCurrentUser() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return cronapi.list.Operations
						.getFirst((cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
								Var.valueOf("select u from User u where u.login = :login"),
								Var.valueOf("login", cronapi.util.Operations.getCurrentUserName()))));
			}
		}.call();
	}

}
