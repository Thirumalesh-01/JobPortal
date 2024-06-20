package com.example.spring_rest_practicer.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring_rest_practicer.model.JobPost;
import com.example.spring_rest_practicer.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	//method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return repo.getAllJobs();

		
	}
	
	// ***************************************************************************

	// method to add a jobPost
public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	
	}



    public JobPost getOneJob(int i) {
      return  repo.getOneJob(i);
    }

    public void deleteJob(int i) {
        repo.deleteJob(i);
    }

    public void updateJob(JobPost jobpost,int j) {
        repo.updateJob(jobpost,j);
    }

	
}