package log_differencing.model.export;

import java.util.Set;

import daikonizer.DaikonInvariants;
import log_differencing.model.interfaces.INode;
import log_differencing.util.time.ITime;

/**
 * Implements a GraphViz exporter (DOT language) for graphs:
 * http://en.wikipedia.org/wiki/DOT_language
 */
public class DotExportFormatter extends GraphExportFormatter {

	@Override
	public String beginGraphString() {
		return "digraph G {\n";
	}

	@Override
	public String endGraphString() {
		return "}\n";
	}

	@Override
	public <T extends INode<T>> String nodeToString(int nodeId, T node,
			boolean isInitial, boolean isTerminal) {

		String attributes = "label=\"" + quote(node.getEType().toString())
				+ "\"";
		if (isInitial) {
			attributes = attributes + ",shape=box";
		} else if (isTerminal) {
			attributes = attributes + ",shape=diamond";
		}

		return "  " + nodeId + " [" + attributes + "];\n";
	}

	private String edgeToString(int nodeSrc, int nodeDst, String attributes,
			Set<String> relations) {
		assert (attributes != null);

		String s = nodeSrc + "->" + nodeDst;

		String l = " [";
		if (!attributes.equals("")) {
			l += attributes;
		}

		if (relations.size() == 1)
			l += "color=red";

		l += "];";

		if (relations.size() > 0) {
			s += l;
		}

		return s + "\n";
	}

	@Override
	public String edgeToStringWithTraceId(int nodeSrc, int nodeDst,
			int traceId, Set<String> relations) {
		String attributes = "label=\"" + traceId + "t\"";
		return edgeToString(nodeSrc, nodeDst, attributes, relations);
	}

	@Override
	public String edgeToStringWithProb(int nodeSrc, int nodeDst, double prob,
			Set<String> relations) {
		String probStr = quote(probToString(prob));
		// String attributes = "label=\"" + probStr + " " + relations.toString()
		// + "\"";

		String attributes = "label=\"" + relations.toString() + "\"";

		return edgeToString(nodeSrc, nodeDst, attributes, relations);
	}

	@Override
	public String edgeToStringWithITimes(int nodeSrc, int nodeDst,
			ITime timeMin, ITime timeMax, ITime timeMedian,
			Set<String> relations) {

		// Make time string
		int sigDigits = 3;
		String timeStr = getITimeString(timeMin, timeMax, timeMedian, sigDigits);

		String attributes = "label=\"" + timeStr + "\"";
		return edgeToString(nodeSrc, nodeDst, attributes, relations);
	}

	@Override
	public String edgeToStringWithITimesAndProb(int nodeSrc, int nodeDst,
			ITime timeMin, ITime timeMax, ITime timeMedian, double prob,
			Set<String> relations) {

		// Make time and probability strings
		int sigDigits = 3;
		String timeStr = getITimeString(timeMin, timeMax, timeMedian, sigDigits);
		String probStr = quote(probToString(prob));

		String attributes = "label=\"" + timeStr + " " + probStr + "\"";
		return edgeToString(nodeSrc, nodeDst, attributes, relations);
	}

	@Override
	public String edgeToStringWithNoProb(int nodeSrc, int nodeDst,
			Set<String> relations) {
		return edgeToString(nodeSrc, nodeDst, "", relations);
	}

	@Override
	public String edgeToStringWithDaikonInvs(int nodeSrc, int nodeDst,
			DaikonInvariants daikonInvs, Set<String> relations) {
		String invStr = quote(daikonInvs.toString());
		String attributes = "label=\"" + invStr + "\"";
		return edgeToString(nodeSrc, nodeDst, attributes, relations);
	}

}
