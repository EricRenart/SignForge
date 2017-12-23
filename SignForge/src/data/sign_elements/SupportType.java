package data.sign_elements;

public enum SupportType {
    OVERHEAD_HOOP_HALF, // New signs in CT use these
    OVERHEAD_HOOP_FULL,
    OVERHEAD_CTDOT_HALF, // Old CT-style "mast arms"
    OVERHEAD_CTDOT_FULL,
    OVERHEAD_NJTA_HALF, // New Style Rust-colored supports seen on the NJ Turnpike and Garden State Parkway
    OVERHEAD_NJTA_FULL,
    OVERHEAD_TRIANGULAR_GANTRY_HALF, // Signs in NYS and most other states
    OVERHEAD_TRIANGULAR_GANTRY_FULL,
    OVERHEAD_SINGLE_POST, // These are seen on the NJ Turnpike
    GROUND_SINGLE_POST,
    GROUND_TWO_POST,
    GROUND_THREE_POST,
}
