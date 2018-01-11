
package ac.uk.napier.set07102cw2016;

/**
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class AnswerChecker {

	public static void main(String[] args) {
		if(args != null && args.length > 0){
			System.out.println(args[0]);
		}
	
		Answer06.main(null);
		Answer07.main(null);
		Answer08.main(null);
		Answer09.main(null);
		Answer10.main(null);
		
	} 
}
