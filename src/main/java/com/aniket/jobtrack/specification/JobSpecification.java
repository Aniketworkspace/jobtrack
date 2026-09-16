package com.aniket.jobtrack.specification;

import com.aniket.jobtrack.entity.Job;
import org.springframework.data.jpa.domain.Specification;

public class JobSpecification {
    public static Specification<Job> hasCompanyName(String companyName){
        return (root, query, builder)->  builder.like(
                builder.lower(root.get("companyName")),
                "%" + companyName.toLowerCase() + "%"
        );
    }

    public static Specification<Job> hasJobTitle(String jobTitle) {
        return (root, query, builder) ->
        builder.equal(
                builder.lower(root.get("jobTitle")),
                jobTitle.toLowerCase()
        );
    }
    public static Specification<Job> hasStatus(String status) {
        return (root, query, builder) ->
                builder.equal(
                        builder.lower(root.get("status")),
                        status.toLowerCase()
                );
    }
}
