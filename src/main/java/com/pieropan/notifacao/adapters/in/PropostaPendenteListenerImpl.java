package com.pieropan.notifacao.adapters.in;

import com.pieropan.notifacao.adapters.in.helpers.MensagensSMSConstant;
import com.pieropan.notifacao.application.domain.Proposta;
import com.pieropan.notifacao.application.ports.NotificacaoSnsService;
import com.pieropan.notifacao.application.ports.PropostaPendenteListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListenerImpl implements PropostaPendenteListener {

    private final NotificacaoSnsService notificacaoSnsService;

    public PropostaPendenteListenerImpl(NotificacaoSnsService notificacaoSnsService) {
        this.notificacaoSnsService = notificacaoSnsService;
    }

    @Override
    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    // Este método é um ouvinte da queue proposta-pendente
    public void recebeMensagemToPropostaPendente(Proposta proposta) {
        String mensagem = String.format(MensagensSMSConstant.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        this.notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
