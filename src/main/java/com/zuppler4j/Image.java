package com.zuppler4j;

/**
 * An image of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version December 2, 2021
 * @param active the active flag of this {@link Image}
 * @param medium the medium of this {@link Image}
 * @param original the original size of this {@link Image}
 * @param thumb the thumb size of this {@link Image}
 * @param tiny the tiny size of this {@link Image}
 * @param xlarge the XL size of this {@link Image}
 * @param xxlarge the XXL size of this {@link Image}
 */
public record Image(Boolean active, String medium, String original, String thumb, String tiny, String xlarge,
                    String xxlarge) {
}