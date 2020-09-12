/**
 * 
 */
package core.tsc.player;





/**
 * (Marker) Interface to manage any kind of players
 * </br>
 * IPlayerMetadata gives indication on the kind of data to use
 * </br>
 * IPlayerPerformedActions gives indication on the kind of actions a Player needs to display to the user/system
 * </br>
 * @author nikiforos
 */
public abstract interface IPlayer extends Runnable, Cloneable, IPlayerMetadata, IPlayerPerformedActions {}