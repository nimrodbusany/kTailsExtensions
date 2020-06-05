package log_differencing.invariants.birelational;

import log_differencing.invariants.BinaryInvariant;
import log_differencing.model.event.EventType;

/**
 * BiRelationalInvariants are invariants mined from subsets of input traces. The
 * mined subset of an input trace is the set subtraces over relation,
 * transitively connected by the ordering relation.
 * 
 */
public abstract class BiRelationalInvariant extends BinaryInvariant {

    protected String orderingRelation;

    public BiRelationalInvariant(EventType first, EventType second,
            String relation, String orderingRelation) {
        super(first, second, relation);
        this.orderingRelation = orderingRelation;
    }

}
