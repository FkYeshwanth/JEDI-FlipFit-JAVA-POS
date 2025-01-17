package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.DAO.AdminDAOImpl;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.NoPendingGymOwnerRequest;
import com.flipkart.exception.NoPendingGymRequest;

import java.util.List;

/**
 * Service class providing functionality for admin-related operations in the FlipFit system.
 */
public class AdminFlipFitService implements AdminFlipFitInterface {

    // Instance of AdminDAOImpl to interact with the data layer.
    AdminDAOImpl adminDAO = new AdminDAOImpl();

    /**
     * Obtains a list of every gym owner within the system.
     *
     * @return List of GymOwner objects.
     */
    public List<GymOwner> getGymOwners() {
        System.out.println("Fetched gym owner details successfully!");
        List<GymOwner> gymOwnersList = null;
        try {
            gymOwnersList = adminDAO.getAllGymOwners();
        } catch (GymOwnerNotFoundException ex) {
            System.out.println("There are no gym owners");
        }
        return gymOwnersList;
    }

    /**
     * Obtains a list of every gym within the system.
     *
     * @return List of Gym objects.
     */
    public List<Gym> getGym() {
        List<Gym> gymList = null;
        try {
            gymList = adminDAO.getAllGyms();
        } catch (GymNotFoundException ex) {
            System.out.println("There are no gyms found");
        }
        return gymList;
    }

    /**
     * Returns all GymOwners object whose requests are pending for approval.
     *
     * @return List of GymOwner objects.
     */
    public List<GymOwner> viewAllPendingGymOwnerRequests() {
        System.out.println("Fetched pending gym owner details successfully!");
        List<GymOwner> pendingReq = null;
        try {
            pendingReq = adminDAO.getPendingGymOwnerRequests();
        } catch (NoPendingGymOwnerRequest ex) {
            System.out.println("There are no pending gym owner requests");
        }
        return pendingReq;
    }

    /**
     * Accepts one request from a gym owner.
     *
     * @param gymOwnerEmail The request's email that has to be approved.
     */
    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail) {
        adminDAO.approveSingleOwnerRequest(gymOwnerEmail);
        System.out.println("Approved gym owner request! " + gymOwnerEmail);
        return true;
    }

    /**
     * Approves all GymOwners whose requests are pending for approval.
     */
    public boolean approveAllPendingGymOwnerRequests() {
        adminDAO.approveAllOwnerRequest();
        System.out.println("Approved all pending gym owner requests!");
        return true;
    }

    /**
     * Returns all Gym objects whose requests are pending for approval.
     *
     * @return List of Gym objects.
     */
    public List<Gym> viewAllPendingGymRequests() {
        System.out.println("Fetched pending gym requests successfully!");
        List<Gym> gymReqList = null;
        try {
            gymReqList = adminDAO.getPendingGymRequests();
        } catch (NoPendingGymRequest ex) {
            System.out.println("There is no pending gym request");
        }
        return gymReqList;
    }

    /**
     * Approves a single Gym object request.
     *
     * @param gymId the id of a gym that needs to be approved.
     * @return true if the gymId is valid else returns false.
     */
    public boolean approveSingleGymRequest(String gymId) {
        adminDAO.approveSingleGymRequest(gymId);
        System.out.println("Successfully approved gym request! " + gymId);
        return true;
    }

    /**
     * Approves all Gyms whose requests are pending for approval.
     */
    public boolean approveAllPendingGymRequests() {
        adminDAO.approveAllGymRequest();
        System.out.println("Successfully approved all pending gym requests!");
        return true;
    }
}
