import javax.swing.*;

public class Student {

	public static void main(String[] args) {

		int numStudents = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of students: "));
		String[] name = new String[numStudents];
		int[] age = new int[numStudents];
		
		for (int i = 0; i < numStudents; i++) {
			name[i] = getValidName("Enter the student's name: ");
			age[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the student's age: "));
		}
		
		StringBuilder acceptedNames = new StringBuilder("Accepted students:\n");
		StringBuilder notAcceptedNames = new StringBuilder("Not accepted students:\n");
		
		boolean hasAcceptedNames = false;
		boolean hasNotAcceptedNames = false;

		
		for (int i = 0; i < numStudents; i++) {
			if (age[i] >= 18) {
				acceptedNames.append(name[i]).append("\n");
				hasAcceptedNames = true;
			}
			else {
				notAcceptedNames.append(name[i]).append("\n");
				hasNotAcceptedNames = true;
			}
		}
	
		if (hasAcceptedNames && hasNotAcceptedNames)
			JOptionPane.showMessageDialog(null, acceptedNames.toString() + "\n" + notAcceptedNames.toString());
		else if (hasAcceptedNames && !hasNotAcceptedNames)
			JOptionPane.showMessageDialog(null, acceptedNames.toString() + "\n" + notAcceptedNames.toString() +"Empty");
		else if (!hasAcceptedNames && hasNotAcceptedNames)
			JOptionPane.showMessageDialog(null, acceptedNames.toString() + "Empty\n\n" + notAcceptedNames.toString());
		else
			JOptionPane.showMessageDialog(null, acceptedNames.toString() + "Empty\n\n" + notAcceptedNames.toString() + "Empty");
}
	
	private static String getValidName(String confirmName) {
		while (true)
		{
			String confirm = JOptionPane.showInputDialog(confirmName);
			if (isValidName(confirm))
				return confirm;
			else
				JOptionPane.showMessageDialog(null, "Invalid name. Please, try again.");
		}
	}
	
	private static boolean isValidName(String name) {
		return name.matches("[\\p{L} ]+");
	}
}
