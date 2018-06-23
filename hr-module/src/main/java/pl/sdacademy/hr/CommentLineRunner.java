package pl.sdacademy.hr;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommentLineRunner {
	public static void load(String[] args, HrManager hrmenager) {
		if (containsAllArguments(args))
			createEmployee(args,hrmenager);
		else
			throw new IllegalArgumentException();

	}

	private static void createEmployee(String[] args, HrManager hrmenager) {
		hrmenager.create(extractorArgument(args[0],"firstName" ),
			extractorArgument(args[1],"lastName"),
			extractorArgument(args[2],"dateOfBirth"));
	}

	private static boolean containsAllArguments(String[] args) {
		return Stream.of(args).allMatch(
			arg -> arg.contains("firstName=") ||
				arg.contains("lastName=") ||
				arg.contains("dateOfBirth=")) &&
				(args.length >= 3);
	}

	private static String extractorArgument (String argument, String argumentKey){
		return argument.split(argumentKey + "=")[1];
	}

	public static List<String> list(HrManager hrManager) {
		return hrManager.findAll().stream().map(Employee::toString).collect(Collectors.toList());
	}
}
