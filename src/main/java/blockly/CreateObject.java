package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CreateObject {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// createObject
	public static Var createOptionsChips() throws Exception {
		return new Callable<Var>() {

			private Var permissions = Var.VAR_NULL;
			private Var skillArrayEmpty = Var.VAR_NULL;

			public Var call() throws Exception {
				permissions = cronapi.map.Operations.createObjectMap();
				cronapi.map.Operations.setMapFieldByKey(permissions, Var.valueOf("readonly"), Var.VAR_FALSE);
				cronapi.map.Operations.setMapFieldByKey(permissions, Var.valueOf("removable"), Var.VAR_TRUE);
				cronapi.map.Operations.setMapFieldByKey(permissions, Var.valueOf("isOpen"), Var.VAR_FALSE);
				cronapi.map.Operations.setMapFieldByKey(permissions, Var.valueOf("hidden"), Var.VAR_TRUE);
				skillArrayEmpty = cronapi.list.Operations.newList();
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("skill"), permissions);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("skill.skills"), skillArrayEmpty);
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Describe this function...
	public static Var getLevelDB() throws Exception {
		return new Callable<Var>() {

			private Var listLevel = Var.VAR_NULL;

			public Var call() throws Exception {
				listLevel = cronapi.database.Operations.query(Var.valueOf("app.entity.SkillLevel"),
						Var.valueOf("select s from SkillLevel s"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("listLevel"), listLevel);
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param textSearch
	 * @return Var
	 */
	// Describe this function...
	public static Var getSkillDB(Var textSearch) throws Exception {
		return new Callable<Var>() {

			private Var skillTemp = Var.VAR_NULL;
			private Var EmptyLevelObject = Var.VAR_NULL;
			private Var skillsList = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;
			private Var guid = Var.VAR_NULL;

			public Var call() throws Exception {
				skillTemp = cronapi.database.Operations.query(Var.valueOf("app.entity.Skill"),
						Var.valueOf("select s from Skill s where s.skill LIKE (CONCAT(\'%\', :skill, \'%\'))"),
						Var.valueOf("skill", textSearch));
				EmptyLevelObject = cronapi.map.Operations.createObjectMap();
				skillsList = cronapi.list.Operations.newList();
				System.out
						.println(Var
								.valueOf(Var.valueOf("user ID:").toString() + cronapi.screen.Operations
										.getValueOfField(Var.valueOf("User.active.id")).toString())
								.getObjectAsString());
				for (Iterator it_i = skillTemp.iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					guid = cronapi.util.Operations.generateUUID();
					System.out.println(Var.valueOf(Var.valueOf("gerei o guid: ").toString() + guid.toString())
							.getObjectAsString());
					cronapi.list.Operations.addLast(skillsList,
							cronapi.object.Operations
									.newObject(Var.valueOf("app.entity.UserSkills"), Var.valueOf("id", guid),
											Var.valueOf("skill", i), Var.valueOf("attachment", Var.VAR_NULL),
											Var.valueOf("user",
													cronapi.object.Operations.newObject(
															Var.valueOf("app.entity.User"),
															Var.valueOf("id",
																	cronapi.screen.Operations.getValueOfField(
																			Var.valueOf("User.active.id"))))),
											Var.valueOf("skillLevel",
													cronapi.object.Operations.newObject(
															Var.valueOf("app.entity.SkillLevel"),
															Var.valueOf("id", Var.VAR_NULL),
															Var.valueOf("level", Var.valueOf("Qual o seu nível?"))))));
				} // end for
				return skillsList;
			}
		}.call();
	}

}
