import javax.swing.*;

public class Student {

	public static void main(String[] args) {

		int numStudents = getValidNumberOfStudents();
		String[] name = new String[numStudents];
		int[] age = new int[numStudents];
		
		for (int i = 0; i < numStudents; i++) {
			name[i] = getValidName("Enter the student's name: ");
			age[i] = getValidAge("Enter the student's age: ");
			if (age[i] < 18) {
				age[i] = getValidAge("The entered age doesn't meet up the application requirements. Please, confirm your age: ");
				if (age [i] < 18)
					JOptionPane.showMessageDialog(null, "Unfortunately, you don't meet up the requirements.");
			}
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
	
	private static int getValidAge(String confirmAgeMessage) {
		while (true) {
			try {
				int confirmAge = Integer.parseInt(JOptionPane.showInputDialog(confirmAgeMessage));
				if (confirmAge >= 0) {
					return confirmAge;
				} else {
					JOptionPane.showMessageDialog(null, "INVALID AGE!");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ERROR: INVALID AGE!");
			}
		}
	}
	
	private static int getValidNumberOfStudents() {
        while (true) {
            try {
                int number = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of students: "));
                if (number >= 0) {
                    return number;
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID NUMBER!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: INVALID INPUT!");
            }
        }
    }
	
	private static String getValidName(String confirmName) {
		while (true)
		{
			String confirm = JOptionPane.showInputDialog(confirmName);
			if (isValidName(confirm))
				return confirm;
			else
				JOptionPane.showMessageDialog(null, "ERROR: INVALID NAME!");
		}
	}
	
	private static boolean isValidName(String name) {
		return name.matches("[\\p{L} ]+");
	}
}
