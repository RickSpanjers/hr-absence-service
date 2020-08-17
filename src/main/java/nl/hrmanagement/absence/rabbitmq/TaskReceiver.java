package nl.hrmanagement.absence.rabbitmq;

import com.google.gson.Gson;
import nl.hrmanagement.absence.service.impl.AbsenceServiceProvider;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.UUID;

@RabbitListener(queues = {"deleteUserAbsences"})
public class TaskReceiver {

    @Autowired
    private AbsenceServiceProvider absenceServiceProvider;

    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(" [x] Received absences to delete for user '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println(" [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) {
        Gson gson = new Gson();
        absenceServiceProvider.deleteAllAbsenceRequestsUser(gson.fromJson(in, UUID.class));
    }
}