package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserSkillsBusiness {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Entidade
	 * @return Var
	 */
	// UserSkills
	public static Var checkDuplicate(Var Entidade) throws Exception {
		return new Callable<Var>() {

			private Var search = Var.VAR_NULL;
			private Var msgErro = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf("search for duplicate skill\n").getObjectAsString());
				search = cronapi.database.Operations.query(Var.valueOf("app.entity.UserSkills"),
						Var.valueOf(
								"select u.skill.skill from UserSkills u where u.cronuser_email = :cronuser_email AND u.skill = :skill"),
						Var.valueOf("cronuser_email",
								cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("cronuser_email"))),
						Var.valueOf("skill", cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("skill"))));
				if (cronapi.database.Operations.hasElement(search).getObjectAsBoolean()) {
					msgErro = Var.valueOf(Var.valueOf("Duplicate skill: ").toString()
							+ cronapi.database.Operations.getField(search, Var.valueOf("this[0]")).toString()
							+ Var.valueOf(" Already registered for user: ").toString() + cronapi.object.Operations
									.getObjectField(Entidade, Var.valueOf("cronuser_email")).toString());
					System.out.println(msgErro.getObjectAsString());
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("error"), msgErro);
					cronapi.util.Operations.throwException(cronapi.util.Operations.createException(msgErro));
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// UserLogged
	public static Var getLoginfromLoggedUser() throws Exception {
		return new Callable<Var>() {

			private Var search = Var.VAR_NULL;
			private Var Entidade = Var.VAR_NULL;
			private Var msgErro = Var.VAR_NULL;
			private Var userid = Var.VAR_NULL;
			private Var userskills = Var.VAR_NULL;

			public Var call() throws Exception {
				return cronapi.util.Operations.getCurrentUserName();
			}
		}.call();
	}

	/**
	 *
	 * @param userid
	 * @return Var
	 */
	// Describe this function...
	public static Var getSkillsfromUser(Var userid) throws Exception {
		return new Callable<Var>() {

			private Var userskills = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf(Var.valueOf("Searching for skills:").toString() + userid.toString())
						.getObjectAsString());
				userskills = cronapi.database.Operations.queryPaged(Var.valueOf("app.entity.UserSkills"),
						Var.valueOf("select u.skill.skill from UserSkills u where u.user.id = :userId"),
						Var.valueOf(true), Var.valueOf("userId", userid));
				while (cronapi.database.Operations.hasElement(userskills).getObjectAsBoolean()) {
					System.out
							.println(Var
									.valueOf(Var.valueOf("skill: ").toString() + cronapi.database.Operations
											.getColumn(userskills, Var.valueOf("this[0]")).toString())
									.getObjectAsString());
					cronapi.database.Operations.next(userskills);
				} // end while
				return Var.valueOf("oi");
			}
		}.call();
	}

}
