package net.hemisoft.ccm.porter

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

@Configuration
@ImportResource("classpath:/net/hemisoft/ccm/porter/porterapi.xml")
class PorterConfig {}