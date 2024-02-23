import java.util.ArrayList;
import java.util.List;

public class CheckList {
    List<Job> jobs;

    CheckList() {
        this.jobs = new ArrayList<>();
    }
    public void addJob(Job job) {
        jobs.add(job);
    }
    public Job getJobAtIndex(int index) {
       return jobs.get(index);
    }

    public void deleteJobByIndex(int index) {
        jobs.remove(index);
    }
    public void changeJobStatus(int index) {
        jobs.get(index).changeStatusDone();
    }

    public int numOfJobs() {
        return jobs.size();
    }

    public List<Job> getFinishedJobs() {
        List<Job> finishedJobs = new ArrayList<>();
        for (Job j : jobs) {
            if (j.isFinished == true) {
                finishedJobs.add(j);
            }
        }
        return finishedJobs;
    }
    public List<Job> getOngoingJobs() {
        List<Job> ongoingJobs = new ArrayList<>();
        for(Job j : jobs) {
            if (j.isFinished == false) {
                ongoingJobs.add(j);
            }
        }
        return ongoingJobs;

    }

    public Integer getNumberOfJobFinished() {
        List<Job> getNumberOfFinishedJobs = getFinishedJobs();
        return getNumberOfFinishedJobs.size();
    }

    public Integer getNumberOfOnGoingJobs() {
        List<Job> getNumberOfOnGoing = getOngoingJobs();
        return getNumberOfOnGoing.size();
    }

    @Override
    public String toString() {

        StringBuilder sb  = new StringBuilder();

        for(Job j : jobs) {
            sb.append(j.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
