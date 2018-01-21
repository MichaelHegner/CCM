package net.hemisoft.ccm

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

import net.hemisoft.ccm.domain.DomainConfig
import net.hemisoft.ccm.porter.PorterConfig
import net.hemisoft.ccm.repository.RepositoryConfig

@SpringBootApplication
class CcmApplication {

	static void main(String[] args) {
		def ctx = SpringApplication.run CcmApplication, args
		def scanner = new Scanner(System.in);
		print 'Press <Return> to quit program'
		scanner.nextLine()
		scanner.close()
		ctx.close()
	}
}
