package blockly.user;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserController {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param user
	 * @return Var
	 */
	// UserController
	public static Var saveUser(Var user) throws Exception {
		return new Callable<Var>() {

			private Var exception = Var.VAR_NULL;
			private Var users = Var.VAR_NULL;

			public Var call() throws Exception {
				try {
					System.out.println(Var
							.valueOf(Var.valueOf("UserId = ").toString()
									+ cronapi.object.Operations.getObjectField(user, Var.valueOf("id")).toString())
							.getObjectAsString());
					users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
							Var.valueOf("select u from User u where u.id = :id"),
							Var.valueOf("id", cronapi.object.Operations.getObjectField(user, Var.valueOf("id"))));
					if (Var.valueOf(cronapi.logic.Operations
							.isNullOrEmpty(cronapi.object.Operations.getObjectField(user, Var.valueOf("id"))))
							.getObjectAsBoolean()) {
						System.out.println(Var.valueOf("INSERT USER").getObjectAsString());
						cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),
								Var.valueOf("resume",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("resume"))),
								Var.valueOf("password",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("password"))),
								Var.valueOf("name",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("name"))),
								Var.valueOf("theme",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("theme"))),
								Var.valueOf("id", Var.valueOf(cronapi.util.Operations.generateUUID())),
								Var.valueOf("weekly_availability",
										cronapi.object.Operations.getObjectField(user,
												Var.valueOf("weekly_availability"))),
								Var.valueOf("login",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("login"))),
								Var.valueOf("email",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("email"))),
								Var.valueOf("picture",
										cronapi.object.Operations.getObjectField(user, Var.valueOf("picture"))));
					} else {
						System.out.println(Var.valueOf("UPDATE USER").getObjectAsString());
						cronapi.database.Operations.update(Var.valueOf("app.entity.User"), user);
					}
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
	 * @param user
	 * @return Var
	 */
	// Describe this function...
	public static Var deleteUser(Var user) throws Exception {
		return new Callable<Var>() {

			private Var exception = Var.VAR_NULL;

			public Var call() throws Exception {
				try {
					cronapi.database.Operations.remove(Var.valueOf("app.entity.User"), user);
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
	 * @return Var
	 */
	// Describe this function...
	public static Var getLoggedUser() throws Exception {
		return new Callable<Var>() {

			private Var users = Var.VAR_NULL;
			private Var userList = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(cronapi.util.Operations.getCurrentUserName().getObjectAsString());
				userList = cronapi.list.Operations.newList();
				users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"),
						Var.valueOf("login", cronapi.util.Operations.getCurrentUserName()));
				for (Iterator it_i = users.iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					cronapi.list.Operations.addLast(userList,
							cronapi.map.Operations.createObjectMapWith(Var.valueOf("user", i), Var.valueOf("skills",
									cronapi.database.Operations.query(Var.valueOf("app.entity.UserSkills"),
											Var.valueOf("select u from UserSkills u where u.user.id = :userId"),
											Var.valueOf("userId",
													cronapi.object.Operations.getObjectField(i, Var.valueOf("id")))))));
				} // end for
				return userList;
			}
		}.call();
	}

	/**
	 *
	 * @param search
	 * @return Var
	 */
	// Describe this function...
	public static Var getUsers(Var search) throws Exception {
		return new Callable<Var>() {

			private Var users = Var.VAR_NULL;
			private Var userList = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;

			public Var call() throws Exception {
				userList = cronapi.list.Operations.newList();
				users = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf(
								"select u from User u where \n(u.name LIKE (CONCAT(\'%\', :name, \'%\')) \nOR u.email LIKE (CONCAT(\'%\', :email, \'%\')) \nOR u.login LIKE (CONCAT(\'%\', :login, \'%\')))   order by u.name asc"),
						Var.valueOf("name", search), Var.valueOf("email", search), Var.valueOf("login", search));
				for (Iterator it_i = users.iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					cronapi.list.Operations.addLast(userList,
							cronapi.map.Operations.createObjectMapWith(Var.valueOf("user", i), Var.valueOf("skills",
									cronapi.database.Operations.query(Var.valueOf("app.entity.UserSkills"),
											Var.valueOf("select u from UserSkills u where u.user.id = :userId"),
											Var.valueOf("userId",
													cronapi.object.Operations.getObjectField(i, Var.valueOf("id")))))));
				} // end for
				return userList;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Describe this function...
	public static Var upload() throws Exception {
		return new Callable<Var>() {

			private Var item = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.util.Operations.upload(Var.VAR_NULL, Var.valueOf("*"), Var.valueOf("20MB"),
						Var.valueOf("false"), (sender_item) -> {
							item = Var.valueOf(sender_item);
						});
				return Var.VAR_NULL;
			}
		}.call();
	}

}
