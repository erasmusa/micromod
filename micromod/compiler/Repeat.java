
package micromod.compiler;

public class Repeat implements Element {
	private Note parent;
	private Fade sibling;
	
	public Repeat( Note parent ) {
		this.parent = parent;
		sibling = new Fade( parent );
	}
	
	public String getToken() {
		return "Repeat";
	}
	
	public Element getParent() {
		return parent;
	}
	
	public Element getSibling() {
		return sibling;
	}
	
	public Element getChild() {
		return null;
	}
	
	public void begin( String value ) {
		if( "Begin".equals( value ) ) {
			parent.beginRepeat();
		} else {
			parent.endRepeat( Parser.parseInteger( value ) );
		}
	}

	public void end() {
	}
}