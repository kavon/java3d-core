/*
 * $RCSfile$
 *
 * Copyright (c) 2007 Sun Microsystems, Inc. All rights reserved.
 *
 * Use is subject to license terms.
 *
 * $Revision$
 * $Date$
 * $State$
 */

package javax.media.j3d;

/**
 * The LineStripArray object draws an array of vertices as a set of
 * connected line strips.  An array of per-strip vertex counts specifies
 * where the separate strips appear in the vertex array.
 * For every strip in the set, each vertex, beginning with
 * the second vertex in the array, defines a line segment to be drawn
 * from the previous vertex to the current vertex.
 */

public class LineStripArray extends GeometryStripArray {

    /**
     * Package scoped default constructor used by cloneNodeComponent.
     */
    LineStripArray() {
    }

    /**
     * Constructs an empty LineStripArray object using the
     * specified parameters.
     *
     * @param vertexCount
     * see {@link GeometryArray#GeometryArray(int,int)}
     * for a description of this parameter.
     *
     * @param vertexFormat
     * see {@link GeometryArray#GeometryArray(int,int)}
     * for a description of this parameter.
     *
     * @param stripVertexCounts
     * see {@link GeometryStripArray#GeometryStripArray(int,int,int[])}
     * for a description of this parameter.
     *
     * @exception IllegalArgumentException if vertexCount is less than 2
     * or any element in the stripVertexCounts array is less than 2
     * ;<br>
     * See {@link GeometryStripArray#GeometryStripArray(int,int,int[])}
     * for more exceptions that can be thrown
     */
    public LineStripArray(int vertexCount,
			  int vertexFormat,
			  int stripVertexCounts[]) {

	super(vertexCount, vertexFormat, stripVertexCounts);

        if (vertexCount < 2 )
	    throw new IllegalArgumentException(J3dI18N.getString("LineStripArray0"));
    }

    /**
     * Constructs an empty LineStripArray object using the
     * specified parameters.
     *
     * @param vertexCount
     * see {@link GeometryArray#GeometryArray(int,int,int,int[])}
     * for a description of this parameter.
     *
     * @param vertexFormat
     * see {@link GeometryArray#GeometryArray(int,int,int,int[])}
     * for a description of this parameter.
     *
     * @param texCoordSetCount
     * see {@link GeometryArray#GeometryArray(int,int,int,int[])}
     * for a description of this parameter.
     *
     * @param texCoordSetMap
     * see {@link GeometryArray#GeometryArray(int,int,int,int[])}
     * for a description of this parameter.
     *
     * @param stripVertexCounts
     * see {@link GeometryStripArray#GeometryStripArray(int,int,int,int[],int[])}
     * for a description of this parameter.
     *
     * @exception IllegalArgumentException if vertexCount is less than 2
     * or any element in the stripVertexCounts array is less than 2
     * ;<br>
     * See {@link GeometryStripArray#GeometryStripArray(int,int,int,int[],int[])}
     * for more exceptions that can be thrown
     *
     * @since Java 3D 1.2
     */
    public LineStripArray(int vertexCount,
			  int vertexFormat,
			  int texCoordSetCount,
			  int[] texCoordSetMap,
			  int stripVertexCounts[]) {

	super(vertexCount, vertexFormat,
	      texCoordSetCount, texCoordSetMap,
	      stripVertexCounts);

        if (vertexCount < 2 )
	    throw new IllegalArgumentException(J3dI18N.getString("LineStripArray0"));
    }

    /**
     * Constructs an empty LineStripArray object using the
     * specified parameters.
     *
     * @param vertexCount
     * see {@link GeometryArray#GeometryArray(int,int,int,int[],int,int[])}
     * for a description of this parameter.
     *
     * @param vertexFormat
     * see {@link GeometryArray#GeometryArray(int,int,int,int[],int,int[])}
     * for a description of this parameter.
     *
     * @param texCoordSetMap
     * see {@link GeometryArray#GeometryArray(int,int,int,int[],int,int[])}
     * for a description of this parameter.
     *
     * @param vertexAttrCount
     * see {@link GeometryArray#GeometryArray(int,int,int,int[],int,int[])}
     * for a description of this parameter.
     *
     * @param vertexAttrSizes
     * see {@link GeometryArray#GeometryArray(int,int,int,int[],int,int[])}
     * for a description of this parameter.
     *
     * @param stripVertexCounts
     * see {@link GeometryStripArray#GeometryStripArray(int,int,int,int[],int,int[],int[])}
     * for a description of this parameter.
     *
     * @exception IllegalArgumentException if vertexCount is less than 2
     * or any element in the stripVertexCounts array is less than 2
     * ;<br>
     * See {@link GeometryStripArray#GeometryStripArray(int,int,int,int[],int,int[],int[])}
     * for more exceptions that can be thrown
     *
     * @since Java 3D 1.4
     */
    public LineStripArray(int vertexCount,
			  int vertexFormat,
			  int texCoordSetCount,
			  int[] texCoordSetMap,
			  int vertexAttrCount,
			  int[] vertexAttrSizes,
			  int[] stripVertexCounts) {

	super(vertexCount, vertexFormat,
	      texCoordSetCount, texCoordSetMap,
	      vertexAttrCount, vertexAttrSizes,
	      stripVertexCounts);

        if (vertexCount < 2 )
	    throw new IllegalArgumentException(J3dI18N.getString("LineStripArray0"));
    }

    /**
     * Creates the retained mode LineStripArrayRetained object that this
     * LineStripArray object will point to.
     */
    void createRetained() {
	this.retained = new LineStripArrayRetained();
	this.retained.setSource(this);
    }

    /**
     * @deprecated replaced with cloneNodeComponent(boolean forceDuplicate)
     */
    public NodeComponent cloneNodeComponent() {
        LineStripArrayRetained rt = (LineStripArrayRetained) retained;
        int stripcounts[] = new int[rt.getNumStrips()];
        rt.getStripVertexCounts(stripcounts);
        int texSetCount = rt.getTexCoordSetCount();
        int[] texMap = null;
        int vertexAttrCount = rt.getVertexAttrCount();
        int[] vertexAttrSizes = null;
        if (texSetCount > 0) {
            texMap = new int[rt.getTexCoordSetMapLength()];
            rt.getTexCoordSetMap(texMap);
        }
        if (vertexAttrCount > 0) {
            vertexAttrSizes = new int[vertexAttrCount];
            rt.getVertexAttrSizes(vertexAttrSizes);
        }
        LineStripArray l = new LineStripArray(rt.getVertexCount(),
                rt.getVertexFormat(),
                texSetCount,
                texMap,
                vertexAttrCount,
                vertexAttrSizes,
                stripcounts);
        l.duplicateNodeComponent(this);
        return l;
     }
}
