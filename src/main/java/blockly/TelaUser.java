package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TelaUser {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Data
	 * @return Var
	 */
	// TelaUser
	public static Var getEmail(Var Data) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.VAR_NULL;
			}
		}.call();
	}

}
