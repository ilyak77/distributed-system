import rmi.*;

/**
 * @author: Yilun Zhang, Qiao Zhang
 * @date: 2016/04/26
 */

/** Remote interface for the test
*/

public interface PingPong{
	public String ping(int idNumber) throws RMIException;
}