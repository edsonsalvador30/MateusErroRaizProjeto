package blockly.utils;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Utility {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Utility
	public static Var getUniversalId() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.valueOf(cronapi.util.Operations.generateUUID());
			}
		}.call();
	}

}
