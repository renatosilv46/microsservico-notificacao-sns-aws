package com.pieropan.notifacao.adapters.out;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.pieropan.notifacao.application.ports.NotificacaoSnsService;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoSnsServiceImpl implements NotificacaoSnsService {

    private final AmazonSNS amazonSNS;

    public NotificacaoSnsServiceImpl(AmazonSNS amazonSNS) {
        this.amazonSNS = amazonSNS;
    }

    @Override
    public void notificar(String telefone, String mensagem) {
        PublishRequest publishRequest = new PublishRequest()
                .withMessage(mensagem).withPhoneNumber(telefone);
        this.amazonSNS.publish(publishRequest);
    }
}
