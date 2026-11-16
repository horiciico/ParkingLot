package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UserDTO;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean
{
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDTO> findAllUsers()
    {
        LOG.info("findAllUsers");
        try
        {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }
        catch(Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<UserDTO> copyUsersToDto(List<User> users)
    {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(new UserDTO(user.getId(), user.getEmail(), user.getPassword(), user.getUsername()));
        }
        return userDTOs;
    }
}
