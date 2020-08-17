package nl.hrmanagement.absence.config;

import nl.hrmanagement.absence.rabbitmq.TaskReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean(name="deleteUserAbsences")
    public Queue deleteUserAttendances() {
        return new Queue("deleteUserAbsences");
    }

    @Bean(name="deleteCompany")
    public Queue deleteCompany() {
        return new Queue("deleteCompany");
    }

    private static class ReceiverConfig {

        @Bean
        public TaskReceiver receiver() {
            return new TaskReceiver();
        }

    }

}