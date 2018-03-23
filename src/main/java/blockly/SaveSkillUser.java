package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SaveSkillUser {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param x
	 * @return Var
	 */
	// saveSkillUser
	public static Var saveSkillUser(Var x) throws Exception {
		return new Callable<Var>() {

			private Var i = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.UserSkills"),
						Var.valueOf("delete from UserSkills where user.id = :id"),
						Var.valueOf("id", cronapi.screen.Operations.getValueOfField(Var.valueOf("User.active.id"))));
				for (Iterator it_i = x.iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					cronapi.database.Operations.insert(Var.valueOf("app.entity.UserSkills"), i);
				} // end for
				System.out.println(Var.valueOf("foiiiiiiiiii").getObjectAsString());
				return Var.VAR_NULL;
			}
		}.call();
	}

}
