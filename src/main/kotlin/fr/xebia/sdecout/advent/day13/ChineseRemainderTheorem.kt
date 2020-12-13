package fr.xebia.sdecout.advent.day13

data class ChineseRemainderTheorem(val congruences: List<Congruence>) {

    fun computeRemainder() = congruences.fold(ComputationState()) { intermediateState, congruence ->
        computeIntermediateState(congruence, intermediateState)
    }.result

    private fun computeIntermediateState(congruence: Congruence, intermediateState: ComputationState) = ComputationState(
        result = incrementUntilResultFits(congruence, intermediateState),
        productOfPreviousModuli = intermediateState.productOfPreviousModuli * congruence.modulus
    )

    private fun incrementUntilResultFits(
        congruence: Congruence, intermediateState: ComputationState,
    ): Long =
        if (congruence.appliesTo(intermediateState.result)) intermediateState.result
        else incrementUntilResultFits(congruence, ComputationState(
                result = intermediateState.result + intermediateState.productOfPreviousModuli,
                productOfPreviousModuli = intermediateState.productOfPreviousModuli
        ))

}
