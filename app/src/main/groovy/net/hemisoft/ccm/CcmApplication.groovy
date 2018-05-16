package net.hemisoft.ccm

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CcmApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(CcmApplication)

	static void main(String[] args) {
		SpringApplication.run CcmApplication, args
	}
	
	@Override
	void run(String... args) throws Exception {
//		log.info('Joining thread, you can press Ctrl+C to shutdown application')
//		Thread.currentThread().join()
	}
}
