package blockly.userskill;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserSkillController {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param userSkills
	 * @param user
	 * @return Var
	 */
	// UserSkillController
	public static Var saveUserSkill(Var userSkills, Var user) throws Exception {
		return new Callable<Var>() {

			private Var item = Var.VAR_NULL;
			private Var exception = Var.VAR_NULL;

			public Var call() throws Exception {
				try {
					System.out.println(cronapi.map.Operations.toMap(user).getObjectAsString());
					cronapi.database.Operations
							.execute(Var.valueOf("app.entity.UserSkills"),
									Var.valueOf("delete from UserSkills where user.id = :id"), Var.valueOf("id",
											cronapi.object.Operations.getObjectField(
													cronapi.list.Operations.getFirst(userSkills),
													Var.valueOf("user.id"))));
					System.out.println(Var.valueOf("DELETED").getObjectAsString());
					for (Iterator it_item = userSkills.iterator(); it_item.hasNext();) {
						item = Var.valueOf(it_item.next());
						System.out.println(Var.valueOf(
								Var.valueOf("=====================ID USER SKILL==================   ").toString()
										+ cronapi.object.Operations.getObjectField(user, Var.valueOf("id")).toString())
								.getObjectAsString());
						cronapi.database.Operations.insert(Var.valueOf("app.entity.UserSkills"),
								Var.valueOf("attachment",
										cronapi.object.Operations.getObjectField(item, Var.valueOf("attachment"))),
								Var.valueOf("skill",
										cronapi.object.Operations.getObjectField(item, Var.valueOf("skill.id"))),
								Var.valueOf("id", cronapi.util.Operations.generateUUID()),
								Var.valueOf("skillLevel",
										cronapi.object.Operations.getObjectField(item, Var.valueOf("skillLevel.id"))),
								Var.valueOf("user", cronapi.object.Operations.getObjectField(user, Var.valueOf("id"))));
					} // end for
				} catch (Exception exception_exception) {
					exception = Var.valueOf(exception_exception);
					System.out.println(exception.getObjectAsString());
				} finally {
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param searchedSkill
	 * @return Var
	 */
	// Describe this function...
	public static Var getSkills(Var searchedSkill) throws Exception {
		return new Callable<Var>() {

			private Var skillList = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;

			public Var call() throws Exception {
				skillList = cronapi.list.Operations.newList();
				for (Iterator it_i = cronapi.database.Operations.query(Var.valueOf("app.entity.Skill"),
						Var.valueOf("select s from Skill s where s.skill LIKE (CONCAT(\'%\', :skill, \'%\'))"),
						Var.valueOf("skill", searchedSkill)).iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					cronapi.list.Operations.addLast(skillList,
							cronapi.object.Operations.newObject(Var.valueOf("app.entity.UserSkills"),
									Var.valueOf("id", cronapi.util.Operations.generateUUID()), Var.valueOf("skill", i),
									Var.valueOf("attachment", cronapi.map.Operations.createObjectMap()),
									Var.valueOf("user", cronapi.map.Operations.createObjectMap()),
									Var.valueOf("skillLevel", Var.VAR_NULL)));
				} // end for
				return skillList;
			}
		}.call();
	}

}
