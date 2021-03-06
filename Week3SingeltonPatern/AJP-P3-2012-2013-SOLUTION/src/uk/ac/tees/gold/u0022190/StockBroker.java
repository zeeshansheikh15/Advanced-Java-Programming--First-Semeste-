package uk.ac.tees.gold.u0022190;

/** <p>This class represents a stock broker who invests in company X.</p>
 * 
 * <p>This program is part of AJP-P3-2012-2013-SOLUTION.</p>
 *
 * <p>AJP-P3-2012-2013-SOLUTION is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.</p>
 *
 * <p>This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.</p>
 *
 * <p>You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.</p>
 *
 * <p>Copyright Mark Truran m.a.truran@tees.ac.uk 17-Oct-2012 </p>
 */
public class StockBroker extends ShareWatcher {

     /** Builds a new StockBroker object, initialising all fields.
     * 
     * @param buy The stock broker will buy shares below this price.
     * @param sell The stock broker will sell shares above this price. 
     * @param increment The stock broker will buy this many share when the 
     * price is right.
     */
    public StockBroker(double buy, double sell, int increment) {
        super(buy, sell, increment);
    }
    
    @Override
    public void updatePrice(double price) {
        
        // The stock broker cannot have a portfolio exceeding 3000 shares
        final int maxShares = 3000;
        
        if (price < buy & portfolio != maxShares) {
            portfolio += increment;
            balance -= (increment * price);
        }
        
        if (price > sell & portfolio > 0) {
            balance += portfolio * price;
            portfolio = 0;
        }        
    }
}