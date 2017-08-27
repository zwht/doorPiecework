// initial state
const state = {
  nativeUserObj: {}
}

// getters
const getters = {
  getUser: state => state.nativeUserObj
}

// actions
const actions = {
  getAllProducts ({ commit }) {
    commit('updateNativeUserObj',"88")
  }
}

// mutations
const mutations = {
  ["updateNativeUserObj"] (state, { products }) {
    state.nativeUserObj = products
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
