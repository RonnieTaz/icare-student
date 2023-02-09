package org.openmrs.module.icare.store.models;

// Generated Oct 7, 2020 12:48:40 PM by Hibernate Tools 5.2.10.Final

import org.openmrs.BaseOpenmrsData;
import org.openmrs.module.icare.core.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StRequisitionItem generated by hbm2java
 */
@Embeddable
class RequisitionItemId implements java.io.Serializable {
	
	@ManyToOne
	@JoinColumn(name = "requisition_id", nullable = false)
	private Requisition requisition;
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;
	
	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Requisition getRequisition() {
		return requisition;
	}
	
	public Item getItem() {
		return item;
	}
}

@Entity
@Table(name = "st_requisition_item")
public class RequisitionItem extends BaseOpenmrsData implements java.io.Serializable {
	
	@EmbeddedId
	private RequisitionItemId id;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Transient
	private List<RequisitionItemStatus> requisitionItemStatuses = new ArrayList<RequisitionItemStatus>(0);
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public RequisitionItemId getReqId() {
		return id;
	}
	
	public void setId(RequisitionItemId id) {
		this.id = id;
	}
	
	public void setRequisition(Requisition requisition) {
		if (id == null) {
			this.id = new RequisitionItemId();
		}
		this.id.setRequisition(requisition);
	}
	
	public void setItem(Item item) {
		if (id == null) {
			this.id = new RequisitionItemId();
		}
		this.id.setItem(item);
	}
	
	public Item getItem() {
		return this.id.getItem();
	}
	
	public Requisition getRequisition() {
		return this.id.getRequisition();
	}
	
	public List<RequisitionItemStatus> getRequisitionItemStatuses() {
		return requisitionItemStatuses;
	}
	
	public void setRequisitionItemStatuses(List<RequisitionItemStatus> requisitionItemStatuses) {
		this.requisitionItemStatuses = requisitionItemStatuses;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> requisitionItemObject = new HashMap<String, Object>();
		if(this.getQuantity() != null) {
			requisitionItemObject.put("quantity", this.getQuantity());
		}

		if(this.getItem() != null) {
			Map<String, Object> itemObject = new HashMap<String, Object>();
			itemObject.put("uuid", this.getReqId().getItem().getUuid());
			if (this.getReqId().getItem().getConcept() != null) {
				itemObject.put("display", this.getReqId().getItem().getConcept().getDisplayString());
			} else if (this.getReqId().getItem().getDrug() != null) {
				itemObject.put("display", this.getReqId().getItem().getDrug().getDisplayName());
			}
			requisitionItemObject.put("item", itemObject);
		}
		if(this.getRequisition() != null) {
			Map<String, Object> requisitionObject = new HashMap<String, Object>();
			requisitionObject.put("uuid", this.getReqId().getRequisition().getUuid());

			requisitionItemObject.put("requisition", requisitionObject);
		}

		if(this.getRequisitionItemStatuses() != null){

			List<Map<String,Object>> requisitionItemStatusesMapList = new ArrayList<>();
			Map<String,Object> requisitionItemStatusMap = new HashMap<>();
			for(RequisitionItemStatus requisitionItemStatus : this.getRequisitionItemStatuses()){
				requisitionItemStatusMap.put("status",requisitionItemStatus.getStatus());
			}
			requisitionItemStatusesMapList.add(requisitionItemStatusMap);
			requisitionItemObject.put("requisitionItemStatuses",requisitionItemStatusesMapList);
		}
		if(this.getVoided() != null){
			requisitionItemObject.put("voided",this.getVoided());
		}
		
		return requisitionItemObject;
	}
	
	public static RequisitionItem fromMap(Map<String,Object> requisitionItemMap){

		RequisitionItem requisitionItem = new RequisitionItem();

		if(requisitionItemMap.get("quantity") != null) {
			requisitionItem.setQuantity((Integer) requisitionItemMap.get("quantity"));
		}

		if(requisitionItemMap.get("item") != null){
			Item item = new Item();
			item.setUuid(((Map)requisitionItemMap.get("item")).get("uuid").toString());
			requisitionItem.setItem(item);
		}

		if(requisitionItemMap.get("requisition") != null){
			Requisition requisition = new Requisition();
			requisition.setUuid(((Map)requisitionItemMap.get("requisition")).get("uuid").toString());
			requisitionItem.setRequisition(requisition);
		}

		if(requisitionItemMap.get("requisitionItemStatuses") != null){

			List<RequisitionItemStatus> requisitionItemStatusesList = new ArrayList<>();
			for(Map<String,Object> requisitionItemMapObject :(List<Map<String, Object>>) requisitionItemMap.get("requisitionItemStatuses")) {
				RequisitionItemStatus requisitionItemStatus = new RequisitionItemStatus();
				requisitionItemStatus.setStatus( requisitionItemMapObject.get("status").toString());
				requisitionItemStatusesList.add(requisitionItemStatus);
			}
			requisitionItem.setRequisitionItemStatuses(requisitionItemStatusesList);

		}

		if(requisitionItemMap.get("voided") != null){
			requisitionItem.setVoided((Boolean) requisitionItemMap.get("voided"));
		}


		return requisitionItem;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
