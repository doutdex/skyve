package modules.test.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * A collection of arcs
 * 
 * @navhas n arcs 0..n AnyBase
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class ArcOneToMany extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "test";
	/** @hidden */
	public static final String DOCUMENT_NAME = "ArcOneToMany";

	/** @hidden */
	public static final String arcsPropertyName = "arcs";

	private List<AnyBase> arcs = new ArrayList<>();

	@Override
	@XmlTransient
	public String getBizModule() {
		return ArcOneToMany.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return ArcOneToMany.DOCUMENT_NAME;
	}

	public static ArcOneToMany newInstance() throws Exception {
		return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage(org.skyve.CORE.getUser().getCustomer(),
														"ArcOneToMany",
														this);
		}
		catch (Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof ArcOneToMany) && 
					this.getBizId().equals(((ArcOneToMany) o).getBizId()));
	}

	/**
	 * {@link #arcs} accessor.
	 **/
	@XmlElement
	public List<AnyBase> getArcs() {
		return arcs;
	}

	/**
	 * {@link #arcs} accessor.
	 * 
	 * @param bizId	The bizId of the element in the list.
	 **/
	public AnyBase getArcsElementById(String bizId) {
		return getElementById(arcs, bizId);
	}

	/**
	 * {@link #arcs} mutator.
	 * 
	 * @param bizId	The bizId of the element in the list.
	 * @param arcs	The new value to set.
	 **/
	public void setArcsElementById(@SuppressWarnings("unused") String bizId, AnyBase element) {
		 setElementById(arcs, element);
	}
}