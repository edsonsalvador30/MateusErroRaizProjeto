package blockly.skilllevel;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SkillLevelController {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// SkillLevelController
	public static Var getSkillLevels() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return cronapi.database.Operations.query(Var.valueOf("app.entity.SkillLevel"),
						Var.valueOf("select s from SkillLevel s where s.active = true"));
			}
		}.call();
	}

}
