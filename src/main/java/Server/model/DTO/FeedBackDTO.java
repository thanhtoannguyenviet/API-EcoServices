package Server.model.DTO;

import Server.model.DB.ClientEntity;
import Server.model.DB.FeedbackEntity;
import Server.model.DB.RateEntity;

public class FeedBackDTO {
    FeedbackEntity feedbackEntity;
    ClientEntity clientEntity;
    RateEntity rateEntity;
    public FeedBackDTO(){}
    public FeedBackDTO(FeedbackEntity feedbackEntity, ClientEntity clientEntity, RateEntity rateEntity) {
        this.feedbackEntity = feedbackEntity;
        this.clientEntity = clientEntity;
        this.rateEntity = rateEntity;
    }

    public FeedbackEntity getFeedbackEntity() {
        return feedbackEntity;
    }

    public void setFeedbackEntity(FeedbackEntity feedbackEntity) {
        this.feedbackEntity = feedbackEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public RateEntity getRateEntity() {
        return rateEntity;
    }

    public void setRateEntity(RateEntity rateEntity) {
        this.rateEntity = rateEntity;
    }
}
