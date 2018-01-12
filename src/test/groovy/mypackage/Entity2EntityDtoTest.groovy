package mypackage

import org.junit.Test
import org.nomin.NominMapper
import org.nomin.core.Nomin

class Entity2EntityDtoTest {
    NominMapper nomin = new Nomin("entity2entitydto.groovy")

  	@Test
	public void test() {
		println nomin
	}
}
