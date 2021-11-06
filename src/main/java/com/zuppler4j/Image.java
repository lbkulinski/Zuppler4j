package com.zuppler4j;

/**
 * An image of the Zuppler API.
 *
 * @author Logan Kulinski, lbkulinski@icloud.com
 * @version November 6, 2021
 * @param active the active flag of this image
 * @param medium the medium of this image
 * @param original the original size of this image
 * @param thumb the thumb size of this image
 * @param tiny the tiny size of this image
 * @param xlarge the XL size of this image
 * @param xxlarge the XXL size of this image
 */
public record Image(Boolean active, String medium, String original, String thumb, String tiny, String xlarge,
                    String xxlarge) {
}