
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in); //Create Scanner to read input later

        CheckList cl = new CheckList(); //Will be used to store the Jobs in a list

        FileReader fr = new FileReader("checklist.csv"); // Read from checklist.csv

        BufferedReader br = new BufferedReader(fr); // Create buffer for checklist.csv

        String line = br.readLine();

        //Add all the lines read from checklist.csv to the CheckList object
        while (line != null) {
            String[] job = line.split(",");

            Job readJob = new Job(job[0], Boolean.valueOf(job[1])); //job[0] = line;  job[1] = status;
            cl.addJob(readJob);
            line = br.readLine();
        }

        System.out.println("-These are your current jobs-");
        System.out.println(cl.toString());

        // Ask user to Quit or create more jobs
        while (true) {
            System.out.println(
                    "Do you want to Quit or create a new job?" +
                    "\nTo Create a New Job just start typing" +
                    "\nTo Quit just type 'Q or Quit'" +
                    "\nTo Delete checklist type 'D or Delete'" +
                    "\nTo change checklist status type 'C or Change'" +
                    "\nTo view finished checklist type 'F or Finished'" +
                    "\nTo view on-going checklist type 'O or Ongoing'"
            );

            String todoList = scanner.nextLine();
            if (todoList.equalsIgnoreCase("quit") || todoList.equalsIgnoreCase("Q")) {
                break;

            } else if (todoList.equalsIgnoreCase("D") || todoList.equalsIgnoreCase("Delete")) {
                System.out.println("To delete a job, enter the number associated with the job.");
                for (int i = 1; i < cl.numOfJobs(); i++) {
                    System.out.println(i + " " + cl.getJobAtIndex(i));
                }
                String index = scanner.nextLine();
                try {
                    int option = Integer.parseInt(index);
                    cl.deleteJobByIndex(option);
                    System.out.println("Deletion completed.");
                } catch (NumberFormatException e) {
                    if (index.equalsIgnoreCase("quit") || index.equalsIgnoreCase("Q")) {
                        System.out.println("DONE");
                        break;
                    }
                }
            } else if (todoList.equalsIgnoreCase("Change") || (todoList.equalsIgnoreCase("C"))) {
                System.out.println("To change a job status, enter the number associated with the job");
                for (int i = 1; i < cl.numOfJobs(); i++) {
                    System.out.println(i + " " + cl.getJobAtIndex(i));
                }
                String index = scanner.nextLine();
                try {
                    int option = Integer.parseInt(index);
                    cl.changeJobStatus(option);
                    System.out.println("Changing status completed");
                } catch (NumberFormatException e) {
                    if (index.equalsIgnoreCase("quit") || index.equalsIgnoreCase("q")) {
                        break;
                    }
                }

            } else if (todoList.equalsIgnoreCase("F") || (todoList.equalsIgnoreCase("Finished"))) {
                System.out.println("This is current your finished checklist");
                for (int i = 0; i < cl.getNumberOfJobFinished(); i++) {
                    System.out.println(i + " " + cl.getFinishedJobs().get(i));
                }

            } else if (todoList.equalsIgnoreCase("O") || (todoList.equalsIgnoreCase("Ongoing"))) {
                System.out.println("This is current your Ongoing checklist");
                for (int i = 0; i < cl.getNumberOfOnGoingJobs(); i++) {
                    System.out.println(i + " " + cl.getOngoingJobs().get(i));
                }

            } else {
                Job toDo = new Job(todoList);
                cl.addJob(toDo);
            }

            FileWriter fw = new FileWriter("checklist.csv");
            // Write the new file out
            for (Job job : cl.jobs) {
                fw.write(job.line + "," + job.isFinished + "\n");
            }
            fw.close();
        }
    }
}
