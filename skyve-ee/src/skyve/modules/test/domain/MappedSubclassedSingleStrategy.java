package modules.test.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import modules.test.MappedExtensionSingleStrategy.MappedExtensionSingleStrategyExtension;
import org.skyve.CORE;

/**
 * Mapped Subclassed Single Strategy
 * <br/>
 * Another Extension document to test that the generated class extends 
			MappedExtensionExtension.java
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class MappedSubclassedSingleStrategy extends MappedExtensionSingleStrategyExtension {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "test";
	/** @hidden */
	public static final String DOCUMENT_NAME = "MappedSubclassedSingleStrategy";

	/** @hidden */
	public static final String subclassIntegerPropertyName = "subclassInteger";

	/**
	 * Subclass Integer
	 **/
	private Integer subclassInteger;

	@Override
	@XmlTransient
	public String getBizModule() {
		return MappedSubclassedSingleStrategy.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return MappedSubclassedSingleStrategy.DOCUMENT_NAME;
	}

	public static MappedSubclassedSingleStrategy newInstance() throws Exception {
		return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage(org.skyve.CORE.getUser().getCustomer(),
														"{text}",
														this);
		}
		catch (Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof MappedSubclassedSingleStrategy) && 
					this.getBizId().equals(((MappedSubclassedSingleStrategy) o).getBizId()));
	}

	/**
	 * {@link #subclassInteger} accessor.
	 * @return	The value.
	 **/
	public Integer getSubclassInteger() {
		return subclassInteger;
	}

	/**
	 * {@link #subclassInteger} mutator.
	 * @param subclassInteger	The new value.
	 **/
	@XmlElement
	public void setSubclassInteger(Integer subclassInteger) {
		preset(subclassIntegerPropertyName, subclassInteger);
		this.subclassInteger = subclassInteger;
	}
}
