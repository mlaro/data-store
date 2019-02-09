package ca.gc.triagency.datastore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.gc.triagency.datastore.model.ApplicationRegistrationsPerOrganization;
import ca.gc.triagency.datastore.model.ApprovedApplicationParticipation;
import ca.gc.triagency.datastore.model.ApprovedAward;
import ca.gc.triagency.datastore.model.Dataset;
import ca.gc.triagency.datastore.model.Dataset.DatasetStatus;
import ca.gc.triagency.datastore.repo.DatasetRepository;
import ca.gc.triagency.datastore.repo.ViewAppRegistrationPerOrganizationRepository;
import ca.gc.triagency.datastore.repo.ViewApprovedAppRegistrations;
import ca.gc.triagency.datastore.repo.ViewApprovedAwards;
import ca.gc.triagency.datastore.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	DatasetRepository datasetRepo;

	@Autowired
	ViewAppRegistrationPerOrganizationRepository appsPerOrgRepo;
	@Autowired
	ViewApprovedAppRegistrations viewApprovedAppRegistrations;
	@Autowired
	ViewApprovedAwards viewApprovedAwards;

	@Override
	public List<ApplicationRegistrationsPerOrganization> getApplicationsPerOrganization() {
		return appsPerOrgRepo.findAll();
	}

	@Override
	public List<Dataset> getApprovedDatasets() {
		return datasetRepo.findByDatasetStatus(DatasetStatus.APPROVED);
	}

	@Override
	public List<ApprovedAward> getApprovedAwards() {
		return viewApprovedAwards.findAll();
	}

	@Override
	public List<ApprovedApplicationParticipation> getApprovedAppParticipations() {
		return viewApprovedAppRegistrations.findAll();
	}

}
