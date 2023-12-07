package com.practice.market.persistence.mapper;

import com.practice.market.domain.PurchaseItem;
import com.practice.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
  @Mappings({
          @Mapping(source = "id.idProducto",target = "productId"),
          @Mapping(source = "cantidad",target = "quantity"),
          //@Mapping(source = "total",target = "total"), // Obs 1
          @Mapping(source = "estado",target = "active"),
  })
  PurchaseItem toPurchaseItem(ComprasProducto producto);

  @InheritInverseConfiguration
  @Mappings({  // obs2
          @Mapping(target = "compra",ignore = true),
          @Mapping(target = "producto",ignore = true),
          @Mapping(target = "id.idCompra",ignore = true),
  })
  ComprasProducto toComprasProducto(PurchaseItem item);

}



// Obs1 : Aqui como el source y el target tienen igual nombre por eso ya no se pone
// obs2 : Aqui se agregan las propiedades que no se van a mapear, por ende se las ignoran
