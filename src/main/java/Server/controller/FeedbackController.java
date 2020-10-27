package Server.controller;

import Server.Comom.MESSAGES;
import Server.DAO.FeedbackDAO;
import Server.model.DB.ClientEntity;
import Server.model.DB.CompanyServiceEntity;
import Server.model.DB.FeedbackEntity;
import Server.model.DB.OrderEntity;
import Server.model.DTO.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Feedback")
public class FeedbackController {
    FeedbackDAO feedbackDAO = new FeedbackDAO();

    @RequestMapping(value = "/Post/",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> Post(@RequestBody FeedbackEntity entity) {
        FeedbackEntity feedbackEntity = feedbackDAO.save(entity);
        return new ResponseEntity(feedbackEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/Put/",
            method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> Put(@RequestBody FeedbackEntity entity) {
        FeedbackEntity feedbackEntity = feedbackDAO.save(entity);
        return new ResponseEntity(feedbackEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/Delete/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        if (feedbackDAO.getByID(id) != null) {
            feedbackDAO.delete(id);
            return new ResponseEntity<>(MESSAGES.DELETEDCOMPLETED, HttpStatus.OK);
        } else return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/GetDetail/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getClient(@PathVariable("id") Long id) {
        FeedbackEntity feedbackEntity = feedbackDAO.getByID(id);
        if (feedbackEntity != null)
            return new ResponseEntity<>(feedbackEntity, HttpStatus.OK);
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
}
