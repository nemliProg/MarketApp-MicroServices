package ma.codipster.orderservice.mappers;

import ma.codipster.orderservice.dto.orderlineitems.OrderLineItemsDto;
import ma.codipster.orderservice.model.OrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineItemsMapper {

    OrderLineItemsMapper INSTANCE = Mappers.getMapper( OrderLineItemsMapper.class );

    OrderLineItemsDto OrderLineItemsToOrderLineItemsDto(OrderLineItems orderLineItems);
    List<OrderLineItemsDto> OrderLineItemsListToOrderLineItemsDtoList(List<OrderLineItems> orderLineItemsList);

    OrderLineItems OrderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto);

    List<OrderLineItems> OrderLineItemsDtoListToOrderLineItemsList(List<OrderLineItemsDto> orderLineItemsDtoList);
}
