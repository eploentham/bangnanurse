/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnanurse.object;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pop
 */
@Entity
@Table(name = "nurse_t_foods_order", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "NurseTFoodsOrder.findAll", query = "SELECT n FROM NurseTFoodsOrder n")})
public class NurseTFoodsOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "foods_order_id", nullable = false, length = 255)
    private String foodsOrderId="";
    @Column(name = "ward_id", length = 255)
    private String wardId="";
    @Column(name = "date_foods_order", length = 255)
    private String dateFoodsOrder="";
    @Column(name = "user_id_foods_order", length = 255)
    private String userIdFoodsOrder="", userNametFoodsOrder="";
    @Column(name = "foods_order_active", length = 255)
    private String foodsOrderActive="";
    @Column(name = "user_id_create", length = 255)
    private String userIdCreate="";
    @Column(name = "user_id_modify", length = 255)
    private String userIdModify="";
    @Column(name = "user_id_cancel", length = 255)
    private String userIdCancel="";
    @Column(name = "date_create", length = 255)
    private String dateCreate="";
    @Column(name = "date_modify", length = 255)
    private String dateModify="";
    @Column(name = "date_cancel", length = 255)
    private String dateCancel="";
    @Column(name = "user_id_foods_receive", length = 255)
    private String userIdFoodsReceive="", userNametFoodsReceive="";
    @Column(name = "user_id_nutritionist", length = 255)
    private String userIdNutritionist="", userNametNutritionist="";
    @Column(name = "branch_id", length = 255)
    private String branchId="";
    @Column(name = "ward_namet", length = 255)
    private String wardNamet="";
    @Column(name = "foods_period_id", length = 255)
    private String foodsPeriodId="",foodsPeriodNamet="";
    @Column(name = "time_foods_order", length = 255)
    private String timeFoodsOrder="";

    public NurseTFoodsOrder() {
    }

    public NurseTFoodsOrder(String foodsOrderId) {
        this.foodsOrderId = foodsOrderId;
    }
    public String getNurseTFoodsOrder() {
        return "nurse_t_foods_order";
    }
    
    public String getFFoodsOrderId() {
        return "foods_order_id";
    }
    public String getFWardId() {
        return "ward_id";
    }
    public String getFDateFoodsOrder() {
        return "date_foods_order";
    }
    public String getFUserIdFoodsOrder() {
        return "user_id_foods_order";
    }
    public String getFFoodsOrderActive() {
        return "foods_order_active";
    }
    public String getFUserIdCreate() {
        return "user_id_create";
    }
    public String getFUserIdModify() {
        return "user_id_modify";
    }
    public String getFUserIdCancel() {
        return "user_id_cancel";
    }
    public String getFDateCreate() {
        return "date_create";
    }
    public String getFDateModify() {
        return "date_modify";
    }
    public String getFDateCancel() {
        return "date_cancel";
    }
    public String getFUserIdFoodsReceive() {
        return "user_id_foods_receive";
    }
    public String getFUserIdNutritionist() {
        return "user_id_nutritionist";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFUserNametFoodsOrder() {
        return "user_namet_foods_order";
    }
    public String getFUserNametFoodsReceive() {
        return "user_namet_foods_receive";
    }
    public String getFUserNametNutritionist() {
        return "user_namet_nutritionist";
    }
    public String getFWardNamet() {
        return "ward_namet";
    }
    public String getFFoodsPeriod() {
        return "foods_period_id";
    }
    public String getFTimeFoodsOrder() {
        return "time_foods_order";
    }

    public String getFoodsOrderId() {
        return foodsOrderId;
    }

    public void setFoodsOrderId(String foodsOrderId) {
        this.foodsOrderId = foodsOrderId;
    }

    public String getWardId() {
        return wardId;
    }
    public String getWardNamet() {
        return wardNamet;
    }
    public void setWardId(String wardId) {
        this.wardId = wardId;
    }
    public void setWardNamet(String wardNamet) {
        this.wardNamet = wardNamet;
    }

    public String getDateFoodsOrder() {
        return dateFoodsOrder;
    }
    public void setDateFoodsOrder(String dateFoodsOrder) {
        this.dateFoodsOrder = dateFoodsOrder;
    }

    public String getUserIdFoodsOrder() {
        return userIdFoodsOrder;
    }
    public void setUserIdFoodsOrder(String userIdFoodsOrder) {
        this.userIdFoodsOrder = userIdFoodsOrder;
    }
    public String getUserNametFoodsOrder() {
        return userNametFoodsOrder;
    }
    public void setUserNametFoodsOrder(String userNametFoodsOrder) {
        this.userNametFoodsOrder = userNametFoodsOrder;
    }

    public String getFoodsOrderActive() {
        return foodsOrderActive;
    }
    public void setFoodsOrderActive(String foodsOrderActive) {
        this.foodsOrderActive = foodsOrderActive;
    }

    public String getUserIdCreate() {
        return userIdCreate;
    }
    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public String getUserIdModify() {
        return userIdModify;
    }
    public void setUserIdModify(String userIdModify) {
        this.userIdModify = userIdModify;
    }

    public String getUserIdCancel() {
        return userIdCancel;
    }
    public void setUserIdCancel(String userIdCancel) {
        this.userIdCancel = userIdCancel;
    }

    public String getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModify() {
        return dateModify;
    }
    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

    public String getDateCancel() {
        return dateCancel;
    }
    public void setDateCancel(String dateCancel) {
        this.dateCancel = dateCancel;
    }

    public String getUserIdFoodsReceive() {
        return userIdFoodsReceive;
    }
    public void setUserIdFoodsReceive(String userIdFoodsReceive) {
        this.userIdFoodsReceive = userIdFoodsReceive;
    }
    public String getUserNametFoodsReceive() {
        return userNametFoodsReceive;
    }
    public void setUserNametFoodsReceive(String userNametFoodsReceive) {
        this.userNametFoodsReceive = userNametFoodsReceive;
    }

    public String getUserIdNutritionist() {
        return userIdNutritionist;
    }
    public void setUserIdNutritionist(String userIdNutritionist) {
        this.userIdNutritionist = userIdNutritionist;
    }

    public String getUserNametNutritionist() {
        return userNametNutritionist;
    }
    public void setUserNametNutritionist(String userNametNutritionist) {
        this.userNametNutritionist = userNametNutritionist;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getFoodsPeriodId() {
        return foodsPeriodId;
    }
    public void setFoodsPeriodId(String foodsPeriodId) {
        this.foodsPeriodId = foodsPeriodId;
    }
    public String getFoodsPeriodNamet() {
        return foodsPeriodNamet;
    }
    public void setFoodsPeriodNamet(String foodsPeriodNamet) {
        this.foodsPeriodNamet = foodsPeriodNamet;
    }

    public String getTimeFoodsOrder() {
        return timeFoodsOrder;
    }
    public void setTimeFoodsOrder(String dateFoodsOrder) {
        this.timeFoodsOrder = dateFoodsOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodsOrderId != null ? foodsOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NurseTFoodsOrder)) {
            return false;
        }
        NurseTFoodsOrder other = (NurseTFoodsOrder) object;
        if ((this.foodsOrderId == null && other.foodsOrderId != null) || (this.foodsOrderId != null && !this.foodsOrderId.equals(other.foodsOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.NurseTFoodsOrder[foodsOrderId=" + foodsOrderId + "]";
    }

}
