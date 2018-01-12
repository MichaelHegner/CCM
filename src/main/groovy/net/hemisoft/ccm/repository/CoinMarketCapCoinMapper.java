//package net.hemisoft.ccm.repository;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//import net.hemisoft.ccm.domain.CoinsOnMarketPlace;
//import net.hemisoft.ccm.porter.Coin;
//
//@Mapper(componentModel = "spring")
//interface CoinMarketCapCoinMapper {
//	
//	@Mappings({
//		@Mapping(source="comp.coin.coinId", 	target="coinId"),
//		@Mapping(source="comp.coin.name", 		target="name"),
//		@Mapping(source="comp.coin.symbol", 	target="symbol"),
//		@Mapping(source="comp.coin.rank", 		target="rank")
//	})
//	Coin porterCoinToCCMCoin(CoinsOnMarketPlace comp);
//	
//	@Mappings({
//		@Mapping(target="coin.id", 		ignore=true),
////		@Mapping(target="coin.coinId", 	source="coin.coinId"),
////		@Mapping(target="coin.name", 	source="coin.name"),
////		@Mapping(target="coin.symbol", 	source="coin.symbol"),
//		@Mapping(source="coin.rank", 			target="coin.rank")
//	})
//	CoinsOnMarketPlace ccmCoinToPorterCoin(Coin coin);
//}
